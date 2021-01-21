public void testMore(){
  String[] paths={"","/","foo","/foo","foo/bar","/foo/bar","foo/bar/baz","/foo/bar/baz","x","/x","x/y","/x/y","x/y/z","/x/y/z"};
  for (  String path : paths) {
    String parent=PathUtils.getParentPath(path);
    String name=PathUtils.getName(path);
    String concat=PathUtils.concat(parent,name);
    assertEquals("original: " + path + " parent: "+ parent+ " name: "+ name+ " concat: "+ concat,path,concat);
  }
}
