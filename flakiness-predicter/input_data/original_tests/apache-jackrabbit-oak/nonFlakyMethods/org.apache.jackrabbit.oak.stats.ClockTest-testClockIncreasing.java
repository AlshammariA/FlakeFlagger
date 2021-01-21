@Test public void testClockIncreasing() throws InterruptedException {
  ScheduledExecutorService executor=Executors.newSingleThreadScheduledExecutor();
  try {
    Clock[] clocks=new Clock[]{Clock.SIMPLE,Clock.ACCURATE,new Clock.Fast(executor)};
    long[] time=new long[clocks.length];
    for (int i=0; i < 10; i++) {
      for (int j=0; j < clocks.length; j++) {
        long now=clocks[j].getTimeIncreasing();
        assertTrue(time[j] < now);
        time[j]=now;
      }
    }
  }
  finally {
    executor.shutdown();
  }
}
