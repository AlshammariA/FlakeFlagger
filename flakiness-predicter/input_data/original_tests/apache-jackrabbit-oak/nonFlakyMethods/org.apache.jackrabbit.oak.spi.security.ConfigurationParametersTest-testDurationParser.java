@Test public void testDurationParser(){
  assertNull(ConfigurationParameters.Milliseconds.of(""));
  assertNull(ConfigurationParameters.Milliseconds.of(null));
  assertEquals(1,ConfigurationParameters.Milliseconds.of("1").value);
  assertEquals(1,ConfigurationParameters.Milliseconds.of("1ms").value);
  assertEquals(1,ConfigurationParameters.Milliseconds.of("  1ms").value);
  assertEquals(1,ConfigurationParameters.Milliseconds.of("  1ms   ").value);
  assertEquals(1,ConfigurationParameters.Milliseconds.of("  1ms  foobar").value);
  assertEquals(1000,ConfigurationParameters.Milliseconds.of("1s").value);
  assertEquals(1500,ConfigurationParameters.Milliseconds.of("1.5s").value);
  assertEquals(1500,ConfigurationParameters.Milliseconds.of("1s 500ms").value);
  assertEquals(60 * 1000,ConfigurationParameters.Milliseconds.of("1m").value);
  assertEquals(90 * 1000,ConfigurationParameters.Milliseconds.of("1m30s").value);
  assertEquals(60 * 60 * 1000 + 90 * 1000,ConfigurationParameters.Milliseconds.of("1h1m30s").value);
  assertEquals(36 * 60 * 60* 1000 + 60 * 60 * 1000 + 90 * 1000,ConfigurationParameters.Milliseconds.of("1.5d1h1m30s").value);
}
