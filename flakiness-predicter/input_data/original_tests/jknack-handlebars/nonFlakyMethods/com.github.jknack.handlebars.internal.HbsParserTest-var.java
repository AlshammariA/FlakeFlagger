@Test public void var(){
  parse("{{variable 678}}");
  parse("{{array.[10]}}");
  parse("{{array.[1foo]}}");
  parse("{{array.['foo']}}");
  parse("{{array.['foo or bar}}]}}");
  parse("{{variable \"string\"}}");
  parse("{{variable \"true\"}}");
  parse("{{variable \"string\" 78}}");
}
