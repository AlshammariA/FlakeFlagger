@Test public void ampvar(){
  parse("{{&variable 678}}");
  parse("{{&variable \"string\"}}");
  parse("{{&variable \"true\"}}");
  parse("{{&variable \"string\" 78}}");
}
