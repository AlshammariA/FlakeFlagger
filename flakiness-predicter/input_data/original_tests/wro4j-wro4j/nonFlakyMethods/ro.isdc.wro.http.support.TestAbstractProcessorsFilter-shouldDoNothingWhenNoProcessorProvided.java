@Test public void shouldDoNothingWhenNoProcessorProvided() throws Exception {
  doFilterWithProcessors(Collections.<ResourcePreProcessor>emptyList());
  Assert.assertEquals(0,outputStream.size());
}
