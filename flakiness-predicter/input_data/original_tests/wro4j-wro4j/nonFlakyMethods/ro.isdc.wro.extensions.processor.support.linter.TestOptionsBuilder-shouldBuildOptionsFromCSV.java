@Test public void shouldBuildOptionsFromCSV(){
  final String actual=optionsBuilder.buildFromCsv("a=1,b=2");
  assertEquals("{\"a\": 1,\"b\": 2}",actual);
}
