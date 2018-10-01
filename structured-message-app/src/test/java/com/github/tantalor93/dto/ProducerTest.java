package com.github.tantalor93.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Autowired
    JacksonTester<Producer> jacksonTester;

    @Test
    public void testSerialize() throws Exception {
        final Producer producer = new Producer("scheduled", "test");

        assertThat(jacksonTester.write(producer)).isEqualToJson("expectedProducer.json");
    }
}