@Test public void testWhitespace(){
  String[] paths=new String[]{" leading","trailing\n"," ","\t","oak: leading","oak:trailing\n","oak: ","oak:\t"};
  NamePathMapper noLocal=new NamePathMapperImpl(new LocalNameMapper(GLOBAL,Collections.<String,String>emptyMap()));
  for (  String path : paths) {
    assertEquals("without local mappings",path,noLocal.getOakPath(path));
    assertEquals("with local mappings",path,npMapper.getOakPath(path));
  }
}
