@Test public void nonConflictingAddProperty(){
  String rev=mk.commit("/","+\"foo\":{\"prop1\":\"value\"}",null,null);
  mk.commit("/foo","^\"prop1\":\"bar\"",rev,null);
  mk.commit("/foo","^\"prop2\":\"baz\"",rev,null);
}
