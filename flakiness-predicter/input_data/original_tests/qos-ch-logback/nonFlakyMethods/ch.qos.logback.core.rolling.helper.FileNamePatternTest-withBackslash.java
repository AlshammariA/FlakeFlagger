@Test public void withBackslash(){
  FileNamePattern pp=new FileNamePattern("c:\\foo\\bar.%i",context);
  assertEquals("c:/foo/bar.3",pp.convertInt(3));
}
