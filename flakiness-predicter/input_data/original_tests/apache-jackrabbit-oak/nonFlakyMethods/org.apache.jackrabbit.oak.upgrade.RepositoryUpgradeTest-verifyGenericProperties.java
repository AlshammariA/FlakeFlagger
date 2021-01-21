@Test public void verifyGenericProperties() throws Exception {
  Session session=createAdminSession();
  try {
    assertTrue(session.nodeExists("/properties"));
    Node properties=session.getNode("/properties");
    assertEquals(PropertyType.BOOLEAN,properties.getProperty("boolean").getType());
    assertEquals(true,properties.getProperty("boolean").getBoolean());
    assertEquals(PropertyType.BINARY,properties.getProperty("binary").getType());
    Binary binary=properties.getProperty("binary").getBinary();
    try {
      InputStream stream=binary.getStream();
      try {
        for (        byte aBINARY : BINARY) {
          assertEquals(aBINARY,(byte)stream.read());
        }
        assertEquals(-1,stream.read());
      }
  finally {
        stream.close();
      }
    }
  finally {
      binary.dispose();
    }
    assertEquals(PropertyType.DATE,properties.getProperty("date").getType());
    assertEquals(DATE.getTimeInMillis(),properties.getProperty("date").getDate().getTimeInMillis());
    assertEquals(PropertyType.DECIMAL,properties.getProperty("decimal").getType());
    assertEquals(new BigDecimal(123),properties.getProperty("decimal").getDecimal());
    assertEquals(PropertyType.DOUBLE,properties.getProperty("double").getType());
    assertEquals(Math.PI,properties.getProperty("double").getDouble());
    assertEquals(PropertyType.LONG,properties.getProperty("long").getType());
    assertEquals(9876543210L,properties.getProperty("long").getLong());
    assertEquals(PropertyType.STRING,properties.getProperty("string").getType());
    assertEquals("test",properties.getProperty("string").getString());
    assertEquals(PropertyType.STRING,properties.getProperty("multiple").getType());
    Value[] values=properties.getProperty("multiple").getValues();
    assertEquals(3,values.length);
    assertEquals("a",values[0].getString());
    assertEquals("b",values[1].getString());
    assertEquals("c",values[2].getString());
  }
  finally {
    session.logout();
  }
}
