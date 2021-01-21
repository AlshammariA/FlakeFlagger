@Test public void clusterNodeId(){
  DocumentMK mk1=createMK(0);
  DocumentMK mk2=createMK(0);
  assertEquals(1,mk1.getClusterInfo().getId());
  assertEquals(2,mk2.getClusterInfo().getId());
  mk1.dispose();
  mk2.dispose();
}
