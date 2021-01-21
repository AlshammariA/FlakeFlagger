@Test public void schedulerHelperIsSynchronized() throws Exception {
  helper=SchedulerHelper.create(new DestroyableLazyInitializer<Runnable>(){
    @Override protected Runnable initialize(){
      return new Runnable(){
        public void run(){
          try {
            LOG.debug("\tRunning thread ...");
            Thread.sleep(40);
          }
 catch (          final Exception e) {
            LOG.error("runnable interrupted",e);
          }
        }
      }
;
    }
  }
);
  final ThreadLocal<Long> period=new InheritableThreadLocal<Long>(){
    @Override protected Long initialValue(){
      return 0l;
    }
  }
;
  final ExecutorService service=Executors.newFixedThreadPool(5);
  for (int i=0; i < 10; i++) {
    period.set(period.get() + 30);
    service.execute(new Runnable(){
      public void run(){
        helper.scheduleWithPeriod(period.get(),TimeUnit.MILLISECONDS);
      }
    }
);
  }
  Thread.sleep(400);
  helper.destroy();
  service.shutdown();
}
