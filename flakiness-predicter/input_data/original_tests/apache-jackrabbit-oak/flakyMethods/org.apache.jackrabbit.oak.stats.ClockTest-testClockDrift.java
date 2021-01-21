@Test public void testClockDrift() throws InterruptedException {
  ScheduledExecutorService executor=Executors.newSingleThreadScheduledExecutor();
  try {
    Clock[] clocks=new Clock[]{Clock.SIMPLE,Clock.ACCURATE,new Clock.Fast(executor)};
    for (    Clock clock : clocks) {
      long drift=clock.getTime() - System.currentTimeMillis();
      final long granularity=getGranularity(clock);
      final long limit=(2 * granularity) / 1000 + 3;
      assertTrue(clock + " unexpected drift: " + drift+ "ms (estimated limit was "+ limit+ "ms, measured granularity was "+ (granularity / 1000f)+ "ms)",Math.abs(drift) <= limit);
    }
    Thread.sleep(100);
    for (    Clock clock : clocks) {
      long drift=clock.getTime() - System.currentTimeMillis();
      final long granularity=getGranularity(clock);
      final long limit=(2 * granularity) / 1000 + 3;
      assertTrue(clock + " unexpected drift ater 100ms: " + drift+ "ms (estimated limit was "+ limit+ "ms, measured granularity was "+ (granularity / 1000f)+ "ms)",Math.abs(drift) <= limit);
    }
  }
  finally {
    executor.shutdown();
  }
}
