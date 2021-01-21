@Test public void testSeveralAddresses(){
  doTest("MECARD:N:Foo Bar;ORG:Company;TEL:5555555555;EMAIL:foo.bar@xyz.com;ADR:City, 10001;" + "ADR:City, 10001;NOTE:This is the memo.;;",null,new String[]{"Foo Bar"},null,new String[]{"City, 10001","City, 10001"},new String[]{"foo.bar@xyz.com"},new String[]{"5555555555"},"Company",null,null,"This is the memo.");
}
