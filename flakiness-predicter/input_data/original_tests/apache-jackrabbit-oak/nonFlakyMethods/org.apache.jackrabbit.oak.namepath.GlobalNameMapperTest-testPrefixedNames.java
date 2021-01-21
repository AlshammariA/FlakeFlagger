@Test public void testPrefixedNames() throws RepositoryException {
  List<String> prefixed=new ArrayList<String>();
  prefixed.add("nt:base");
  prefixed.add("foo: bar");
  prefixed.add("quu:bar ");
  prefixed.add("unknown:bar");
  for (  String name : prefixed) {
    assertEquals(name,mapper.getOakNameOrNull(name));
    assertEquals(name,mapper.getOakName(name));
    assertEquals(name,mapper.getJcrName(name));
  }
}
