public void testPathElements(){
  String[] invalidPaths=new String[]{"//","/a/","a/","/a//","a//b"};
  for (  String path : invalidPaths) {
    try {
      PathUtils.elements(path);
      fail();
    }
 catch (    AssertionError e) {
    }
  }
}
