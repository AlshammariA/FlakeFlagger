@Test public void testNoPassword(){
  doTest("WIFI:S:NoPassword;P:;T:;;","NoPassword",null,"nopass");
  doTest("WIFI:S:No Password;P:;T:;;","No Password",null,"nopass");
}
