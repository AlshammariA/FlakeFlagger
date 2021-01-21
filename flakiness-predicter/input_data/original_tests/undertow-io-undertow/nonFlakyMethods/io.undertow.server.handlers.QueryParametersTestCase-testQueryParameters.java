@Test public void testQueryParameters() throws IOException {
  TestHttpClient client=new TestHttpClient();
  try {
    runTest(client,"{unicode=>Iñtërnâtiônàližætiøn}","/path?unicode=Iñtërnâtiônàližætiøn");
    runTest(client,"{a=>b,value=>bb bb}","/path?a=b&value=bb%20bb");
    runTest(client,"{a=>b,value=>[bb,cc]}","/path?a=b&value=bb&value=cc");
    runTest(client,"{a=>b,s =>,t =>,value=>[bb,cc]}","/path?a=b&value=bb&value=cc&s%20&t%20");
    runTest(client,"{a=>b,s =>,t =>,value=>[bb,cc]}","/path?a=b&value=bb&value=cc&s%20&t%20&");
    runTest(client,"{a=>b,s =>,t =>,u=>,value=>[bb,cc]}","/path?a=b&value=bb&value=cc&s%20&t%20&u");
  }
  finally {
    client.getConnectionManager().shutdown();
  }
}
