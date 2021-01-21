@Test public void testRelativize_oneAbsoluteOneRelative(){
  try {
    fs.getPath("/foo/bar").relativize(fs.getPath("foo"));
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
  try {
    fs.getPath("foo").relativize(fs.getPath("/foo/bar"));
    fail();
  }
 catch (  IllegalArgumentException expected) {
  }
}
