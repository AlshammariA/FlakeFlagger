@Test public void testInvalidOakPaths(){
  getJcrPath("//");
  getJcrPath("/foo//");
  getJcrPath("/..//");
  getJcrPath("/..");
  getJcrPath("/foo/../..");
}
