package com.kai.async.demo;

public class Bootstrap {

    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();

        Worker worker = bootstrap.newWorker();

        Wrapper wrapper = new Wrapper();
        wrapper.setWorker(worker);
        wrapper.setParam("Hello ");

        bootstrap.doWorker(wrapper).addListener(new Listener() {
            @Override
            public void result(Object result) {
                System.out.println("最后的执行结果：" + result);
            }
        });

        System.out.println(Thread.currentThread().getName());
    }

    public Wrapper doWorker(Wrapper wrapper) {
        new Thread(() -> {
            Worker worker = wrapper.getWorker();
            String result = worker.action(wrapper.getParam());
            wrapper.getListener().result(result);
        }).start();
        return wrapper;
    }

    public Worker newWorker() {
        return new Worker() {

            public String action(Object o) {
                try {
                    System.out.println("任务正在执行");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return o + "World";
            }
        };
    }
}