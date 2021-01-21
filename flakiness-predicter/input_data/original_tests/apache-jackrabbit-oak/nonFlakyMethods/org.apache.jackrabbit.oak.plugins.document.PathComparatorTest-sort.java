@Test public void sort(){
  List<String> paths=new ArrayList<String>();
  paths.add("/foo");
  paths.add("/foo/bar");
  paths.add("/bar/qux");
  paths.add("/");
  paths.add("/bar");
  Collections.sort(paths,PathComparator.INSTANCE);
  List<String> expected=Lists.newArrayList("/bar/qux","/foo/bar","/bar","/foo","/");
  assertEquals(expected,paths);
}
