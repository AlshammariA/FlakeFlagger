@Test public void testGetPath(){
  NameMapper nameMapper=new GlobalNameMapper(Collections.singletonMap("jr","http://jackrabbit.apache.org"));
  NamePathMapper npMapper=new NamePathMapperImpl(nameMapper);
  Map<String,String> paths=new HashMap<String,String>();
  paths.put(null,null);
  paths.put(getTestPath(),getTestPath());
  paths.put("/","/");
  paths.put("/jr:testPath","/jr:testPath");
  paths.put("/{http://jackrabbit.apache.org}testPath","/jr:testPath");
  for (  String path : paths.keySet()) {
    AbstractAccessControlList acl=createACL(path,Collections.<ACE>emptyList(),npMapper);
    assertEquals(paths.get(path),acl.getPath());
  }
}
