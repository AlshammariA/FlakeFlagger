@Test public void testBizcard(){
  doTest("BIZCARD:N:Sean;X:Owen;C:Google;A:123 Main St;M:+12125551212;E:srowen@example.org;",null,new String[]{"Sean Owen"},null,new String[]{"123 Main St"},new String[]{"srowen@example.org"},new String[]{"+12125551212"},"Google",null,null,null);
}
