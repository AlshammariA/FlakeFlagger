@Test public void openCloseOpen(){
  MemoryDocumentStore ds=new MemoryDocumentStore();
  MemoryBlobStore bs=new MemoryBlobStore();
  DocumentMK mk1=createMK(1,0,ds,bs);
  mk1.commit("/","+\"a\": {}",null,null);
  mk1.commit("/","-\"a\"",null,null);
  mk1.runBackgroundOperations();
  DocumentMK mk2=createMK(2,0,ds,bs);
  mk2.commit("/","+\"a\": {}",null,null);
  mk2.commit("/","-\"a\"",null,null);
  mk2.runBackgroundOperations();
  DocumentMK mk3=createMK(3,0,ds,bs);
  mk3.commit("/","+\"a\": {}",null,null);
  mk3.commit("/","-\"a\"",null,null);
  mk3.runBackgroundOperations();
  DocumentMK mk4=createMK(4,0,ds,bs);
  mk4.commit("/","+\"a\": {}",null,null);
  mk4.runBackgroundOperations();
  DocumentMK mk5=createMK(5,0,ds,bs);
  mk5.commit("/","-\"a\"",null,null);
  mk5.commit("/","+\"a\": {}",null,null);
  mk1.dispose();
  mk2.dispose();
  mk3.dispose();
  mk4.dispose();
  mk5.dispose();
}
