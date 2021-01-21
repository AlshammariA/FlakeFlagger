@Test public void clusterNodeInfo(){
  MemoryDocumentStore store=new MemoryDocumentStore();
  ClusterNodeInfo c1, c2, c3, c4;
  c1=ClusterNodeInfo.getInstance(store,"m1",null);
  assertEquals(1,c1.getId());
  c1.dispose();
  c1=ClusterNodeInfo.getInstance(store,"m1",null);
  assertEquals(1,c1.getId());
  c1.dispose();
  c2=ClusterNodeInfo.getInstance(store,"m2",null);
  assertEquals(2,c2.getId());
  c3=ClusterNodeInfo.getInstance(store,"m3","/a");
  assertEquals(3,c3.getId());
  c2.dispose();
  c3.dispose();
  c3=ClusterNodeInfo.getInstance(store,"m3","/a");
  assertEquals(3,c3.getId());
  c3.dispose();
  c4=ClusterNodeInfo.getInstance(store,"m3","/b");
  assertEquals(4,c4.getId());
  c1.dispose();
}
