@Test public void testChannels() throws IOException {
  try (FileChannel channel=FileChannel.open(path("/test.txt"),CREATE_NEW,WRITE)){
    ByteBuffer buf1=UTF_8.encode("hello");
    ByteBuffer buf2=UTF_8.encode(" world");
    while (buf1.hasRemaining() || buf2.hasRemaining()) {
      channel.write(new ByteBuffer[]{buf1,buf2});
    }
  }
   try (SeekableByteChannel channel=Files.newByteChannel(path("/test.txt"),READ)){
    ByteBuffer buffer=ByteBuffer.allocate(100);
    while (channel.read(buffer) != -1) {
    }
    buffer.flip();
    assertEquals("hello world",UTF_8.decode(buffer).toString());
  }
   byte[] bytes=preFilledBytes(100);
  Files.write(path("/test"),bytes);
  try (SeekableByteChannel channel=Files.newByteChannel(path("/test"),READ,WRITE)){
    ByteBuffer buffer=ByteBuffer.wrap(preFilledBytes(50));
    channel.position(50);
    channel.write(buffer);
    buffer.flip();
    channel.write(buffer);
    channel.position(0);
    ByteBuffer readBuffer=ByteBuffer.allocate(150);
    while (readBuffer.hasRemaining()) {
      channel.read(readBuffer);
    }
    byte[] expected=concat(preFilledBytes(50),preFilledBytes(50),preFilledBytes(50));
    assertArrayEquals(expected,readBuffer.array());
  }
   try (FileChannel channel=FileChannel.open(path("/test"),READ,WRITE)){
    assertEquals(150,channel.size());
    channel.truncate(10);
    assertEquals(10,channel.size());
    ByteBuffer buffer=ByteBuffer.allocate(20);
    assertEquals(10,channel.read(buffer));
    buffer.flip();
    byte[] expected=new byte[20];
    System.arraycopy(preFilledBytes(10),0,expected,0,10);
    assertArrayEquals(expected,buffer.array());
  }
 }
