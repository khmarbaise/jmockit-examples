package com.soebes.jmockit.examples;

import static org.fest.assertions.api.Assertions.assertThat;
import mockit.Expectations;
import mockit.Mocked;

import org.testng.annotations.Test;

public class BitMaskTest
{
    @Mocked
    private BitMask bitmask;

    @Test
    public void shouldReturnTheDefinedResult()
    {
        new Expectations() {{
            bitmask.getBitMaskValue();
            result = 7;
            bitmask.isBitSet( anyInt);
            result = true;
        }};

        System.out.println("BitMask:" + bitmask);
        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 7 );
        assertThat(bitmask.isBitSet( 3 )).isTrue();
    }
}
