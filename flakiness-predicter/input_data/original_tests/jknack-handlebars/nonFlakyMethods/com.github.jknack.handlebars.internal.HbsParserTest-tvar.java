@Test public void tvar(){
  parse("{{{variable 678}}}");
  parse("{{{variable \"string\"}}}");
  parse("{{{variable \"true\"}}}");
  parse("{{{variable \"string\" 78}}}");
}
