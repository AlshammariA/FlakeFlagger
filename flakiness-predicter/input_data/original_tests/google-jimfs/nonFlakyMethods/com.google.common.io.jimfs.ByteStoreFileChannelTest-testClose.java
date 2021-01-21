@Test public void testClose() throws IOException {
  ByteStoreFileChannel channel=channel(store(0),READ,WRITE);
  ExecutorService executor=Executors.newSingleThreadExecutor();
  assertTrue(channel.isOpen());
  channel.close();
  assertFalse(channel.isOpen());
  try {
    channel.position();
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.position(0);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.lock();
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.lock(0,10,true);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.tryLock();
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.tryLock(0,10,true);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.force(true);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.write(buffer("111"));
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.write(buffer("111"),10);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.write(new ByteBuffer[]{buffer("111"),buffer("111")});
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.write(new ByteBuffer[]{buffer("111"),buffer("111")},0,2);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.transferFrom(new ByteBufferChannel(bytes("1111")),0,4);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.truncate(0);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.read(buffer("111"));
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.read(buffer("111"),10);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.read(new ByteBuffer[]{buffer("111"),buffer("111")});
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.read(new ByteBuffer[]{buffer("111"),buffer("111")},0,2);
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  try {
    channel.transferTo(0,10,new ByteBufferChannel(buffer("111")));
    fail();
  }
 catch (  ClosedChannelException expected) {
  }
  executor.shutdown();
}
