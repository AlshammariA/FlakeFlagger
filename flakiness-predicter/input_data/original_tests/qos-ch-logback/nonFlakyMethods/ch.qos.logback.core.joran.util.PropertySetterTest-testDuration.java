@Test public void testDuration(){
  setter.setProperty("duration","1.4 seconds");
  assertEquals(1400,house.getDuration().getMilliseconds());
}
