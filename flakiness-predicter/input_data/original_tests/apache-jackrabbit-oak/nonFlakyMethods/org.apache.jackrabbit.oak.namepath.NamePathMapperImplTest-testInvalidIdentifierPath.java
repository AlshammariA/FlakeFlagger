@Test public void testInvalidIdentifierPath(){
  String uuid=IdentifierManager.generateUUID();
  List<String> invalid=new ArrayList<String>();
  invalid.add('[' + uuid + "]abc");
  invalid.add('[' + uuid + "]/a/b/c");
  for (  String jcrPath : invalid) {
    assertNull(npMapper.getOakPath(jcrPath));
  }
}
