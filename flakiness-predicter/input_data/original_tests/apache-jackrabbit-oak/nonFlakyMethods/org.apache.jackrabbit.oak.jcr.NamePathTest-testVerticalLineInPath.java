@Test public void testVerticalLineInPath() throws Exception {
  List<String> paths=ImmutableList.of("/jcr:con|ent","/jcr:|ontent","/jcr:conten|","/|ontent","/conten|","/con|ent");
  testPaths(paths);
}
