@Test public void testOrderShorterFirst(){
  HttpString a=new HttpString("a");
  HttpString aa=new HttpString("aa");
  Assert.assertEquals(-1,a.compareTo(aa));
}
