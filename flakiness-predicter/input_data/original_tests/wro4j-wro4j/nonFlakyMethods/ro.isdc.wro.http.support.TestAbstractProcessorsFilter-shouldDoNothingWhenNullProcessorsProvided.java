@Test public void shouldDoNothingWhenNullProcessorsProvided() throws Exception {
  doFilterWithProcessors(null);
  Assert.assertEquals(0,outputStream.size());
}
