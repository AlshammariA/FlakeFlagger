@Test public void testRecursiveWildcardResources() throws IOException {
  victim.locate(createUri("/css/**.css"));
}
