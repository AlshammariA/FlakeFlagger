@Test public void shouldMergeEmptyModel(){
  victim.merge(new WroModel());
  assertEquals(buildValidModel(),victim);
}
