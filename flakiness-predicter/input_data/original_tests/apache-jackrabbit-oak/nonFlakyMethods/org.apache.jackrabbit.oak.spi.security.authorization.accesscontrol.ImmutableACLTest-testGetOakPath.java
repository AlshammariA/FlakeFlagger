@Test public void testGetOakPath(){
  NamePathMapper npMapper=new NamePathMapperImpl(new LocalNameMapper(singletonMap("oak","http://jackrabbit.apache.org"),singletonMap("jcr","http://jackrabbit.apache.org")));
  Map<String,String> paths=new HashMap<String,String>();
  paths.put(null,null);
  paths.put(getTestPath(),getTestPath());
  paths.put("/","/");
  String oakPath="/oak:testPath";
  String jcrPath="/jcr:testPath";
  paths.put(jcrPath,oakPath);
  jcrPath="/{http://jackrabbit.apache.org}testPath";
  paths.put(jcrPath,oakPath);
  for (  String path : paths.keySet()) {
    AbstractAccessControlList acl=createACL(path,Collections.<ACE>emptyList(),npMapper);
    assertEquals(paths.get(path),acl.getOakPath());
  }
}
