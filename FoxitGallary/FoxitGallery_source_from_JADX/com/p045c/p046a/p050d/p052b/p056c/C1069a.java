package com.p045c.p046a.p050d.p052b.p056c;

import android.os.Process;
import android.util.Log;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.c.a.d.b.c.a */
public class C1069a extends ThreadPoolExecutor {
    private final AtomicInteger f2830a;
    private final C1066c f2831b;

    /* renamed from: com.c.a.d.b.c.a.a */
    public static class C1064a implements ThreadFactory {
        int f2823a;

        /* renamed from: com.c.a.d.b.c.a.a.1 */
        class C10631 extends Thread {
            final /* synthetic */ C1064a f2822a;

            C10631(C1064a c1064a, Runnable runnable, String str) {
                this.f2822a = c1064a;
                super(runnable, str);
            }

            public void run() {
                Process.setThreadPriority(10);
                super.run();
            }
        }

        public C1064a() {
            this.f2823a = 0;
        }

        public Thread newThread(Runnable runnable) {
            Thread c10631 = new C10631(this, runnable, "fifo-pool-thread-" + this.f2823a);
            this.f2823a++;
            return c10631;
        }
    }

    /* renamed from: com.c.a.d.b.c.a.b */
    static class C1065b<T> extends FutureTask<T> implements Comparable<C1065b<?>> {
        private final int f2824a;
        private final int f2825b;

        public C1065b(Runnable runnable, T t, int i) {
            super(runnable, t);
            if (runnable instanceof C1070b) {
                this.f2824a = ((C1070b) runnable).m5469b();
                this.f2825b = i;
                return;
            }
            throw new IllegalArgumentException("FifoPriorityThreadPoolExecutor must be given Runnables that implement Prioritized");
        }

        public int m5465a(C1065b<?> c1065b) {
            int i = this.f2824a - c1065b.f2824a;
            return i == 0 ? this.f2825b - c1065b.f2825b : i;
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m5465a((C1065b) obj);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1065b)) {
                return false;
            }
            C1065b c1065b = (C1065b) obj;
            return this.f2825b == c1065b.f2825b && this.f2824a == c1065b.f2824a;
        }

        public int hashCode() {
            return (this.f2824a * 31) + this.f2825b;
        }
    }

    /* renamed from: com.c.a.d.b.c.a.c */
    public enum C1066c {
        IGNORE,
        LOG {
            protected void m5467a(Throwable th) {
                if (Log.isLoggable("PriorityExecutor", 6)) {
                    Log.e("PriorityExecutor", "Request threw uncaught throwable", th);
                }
            }
        },
        THROW {
            protected void m5468a(Throwable th) {
                super.m5466a(th);
                throw new RuntimeException(th);
            }
        };

        protected void m5466a(Throwable th) {
        }
    }

    public C1069a(int i) {
        this(i, C1066c.LOG);
    }

    public C1069a(int i, int i2, long j, TimeUnit timeUnit, ThreadFactory threadFactory, C1066c c1066c) {
        super(i, i2, j, timeUnit, new PriorityBlockingQueue(), threadFactory);
        this.f2830a = new AtomicInteger();
        this.f2831b = c1066c;
    }

    public C1069a(int i, C1066c c1066c) {
        this(i, i, 0, TimeUnit.MILLISECONDS, new C1064a(), c1066c);
    }

    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            if (future.isDone() && !future.isCancelled()) {
                try {
                    future.get();
                } catch (Throwable e) {
                    this.f2831b.m5466a(e);
                } catch (Throwable e2) {
                    this.f2831b.m5466a(e2);
                }
            }
        }
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new C1065b(runnable, t, this.f2830a.getAndIncrement());
    }
}
