package com.github.tantalor93.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@JsonTest
@RunWith(SpringRunner.class)
public class MessageTest {

    @Autowired
    JacksonTester<Message> jsonTester;

    @Test
    public void testSerialize() throws Exception {
        final Message message = new Message(new Producer("scheduled", "test"), "test message");

        assertThat(this.jsonTester.write(message)).isEqualToJson("expectedMessage.json");
    }

    @Test
    public void testDeserialize() throws IOException {
        final Message expected = new Message(new Producer("scheduled", "test"), "test message");

        final Message parsed = jsonTester.readObject(this.getClass().getResourceAsStream("expectedMessage.json"));

        assertThat(parsed).isEqualTo(expected);
    }
}