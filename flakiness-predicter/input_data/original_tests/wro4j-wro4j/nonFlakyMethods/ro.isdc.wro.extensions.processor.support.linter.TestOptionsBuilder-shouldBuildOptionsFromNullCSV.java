@Test public void shouldBuildOptionsFromNullCSV(){
  assertEquals("{}",optionsBuilder.buildFromCsv(null));
}
