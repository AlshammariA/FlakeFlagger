@Test public void testSimpleNames() throws RepositoryException {
  List<String> simpleNames=new ArrayList<String>();
  simpleNames.add("foo");
  simpleNames.add(" foo ");
  simpleNames.add("foo.bar");
  simpleNames.add(".");
  simpleNames.add("..");
  simpleNames.add("/");
  simpleNames.add(" ");
  for (  String name : simpleNames) {
    assertEquals(name,mapper.getOakNameOrNull(name));
    assertEquals(name,mapper.getOakName(name));
    assertEquals(name,mapper.getJcrName(name));
  }
}
