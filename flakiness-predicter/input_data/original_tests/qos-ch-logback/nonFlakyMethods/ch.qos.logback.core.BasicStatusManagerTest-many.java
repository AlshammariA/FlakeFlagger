@Test public void many(){
  int margin=300;
  int len=MAX_HEADER_COUNT + TAIL_SIZE + margin;
  for (int i=0; i < len; i++) {
    bsm.add(new ErrorStatus("" + i,this));
  }
  List<Status> statusList=bsm.getCopyOfStatusList();
  assertNotNull(statusList);
  assertEquals(MAX_HEADER_COUNT + TAIL_SIZE,statusList.size());
  List<Status> witness=new ArrayList<Status>();
  for (int i=0; i < MAX_HEADER_COUNT; i++) {
    witness.add(new ErrorStatus("" + i,this));
  }
  for (int i=0; i < TAIL_SIZE; i++) {
    witness.add(new ErrorStatus("" + (MAX_HEADER_COUNT + margin + i),this));
  }
  assertEquals(witness,statusList);
}
