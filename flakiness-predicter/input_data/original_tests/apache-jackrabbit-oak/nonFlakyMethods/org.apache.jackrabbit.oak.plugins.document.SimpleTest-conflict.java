@Test public void conflict(){
  DocumentMK mk=createMK();
  mk.commit("/","+\"a\": {}",null,null);
  try {
    mk.commit("/","+\"b\": {}  +\"a\": {}",null,null);
    fail();
  }
 catch (  MicroKernelException e) {
  }
  mk.commit("/","+\"b\": {}",null,null);
  mk.dispose();
}
