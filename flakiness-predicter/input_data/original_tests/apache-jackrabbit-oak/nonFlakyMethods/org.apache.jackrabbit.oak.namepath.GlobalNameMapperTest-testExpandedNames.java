@Test public void testExpandedNames() throws RepositoryException {
  Map<String,String> jcrToOak=new HashMap<String,String>();
  jcrToOak.put("{}foo","foo");
  jcrToOak.put("{foo","{foo");
  jcrToOak.put("{foo}","{foo}");
  jcrToOak.put("{0} foo","{0} foo");
  jcrToOak.put("{","{");
  jcrToOak.put("{http://www.jcp.org/jcr/nt/1.0}base","nt:base");
  jcrToOak.put("{http://www.example.com/foo}bar","foo:bar");
  jcrToOak.put("{http://www.example.com/quu}bar","quu:bar");
  for (  String jcrName : jcrToOak.keySet()) {
    assertEquals(jcrToOak.get(jcrName),mapper.getOakNameOrNull(jcrName));
    assertEquals(jcrToOak.get(jcrName),mapper.getOakName(jcrName));
  }
  assertNull(mapper.getOakNameOrNull("{http://www.example.com/bar}bar"));
  try {
    mapper.getOakName("{http://www.example.com/bar}bar");
    fail("RepositoryException expected");
  }
 catch (  RepositoryException e) {
  }
}
