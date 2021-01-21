@Test public void testCRUD() throws RepositoryException {
  Session session=getAdminSession();
  Node hello=session.getRootNode().addNode("hello");
  hello.setProperty("world","hello world");
  session.save();
  assertEquals("hello world",session.getProperty("/hello/world").getString());
  session.getNode("/hello").setProperty("world","Hello, World!");
  session.save();
  assertEquals("Hello, World!",session.getProperty("/hello/world").getString());
  session.getNode("/hello").remove();
  session.save();
  assertTrue(!session.propertyExists("/hello/world"));
}
