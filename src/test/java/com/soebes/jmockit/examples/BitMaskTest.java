package com.soebes.jmockit.examples;

import static org.fest.assertions.api.Assertions.assertThat;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.testng.annotations.Test;

public class BitMaskTest
{
    @Mocked
    private BitMask bitmask;

    @Test
    public void shouldReturnTheDefinedResults()
    {
        new NonStrictExpectations() {{
            bitmask.getBitMaskValue();
            result = 7;

            bitmask.isBitSet( anyInt );
            returns (true, true, true);
            result = false;
            
        }};

        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 7 );
        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 7 );
        assertThat(bitmask.isBitSet( 0 )).isTrue();
        assertThat(bitmask.isBitSet( 1 )).isTrue();
        assertThat(bitmask.isBitSet( 2 )).isTrue();

        assertThat(bitmask.isBitSet( 3 )).isFalse();
        assertThat(bitmask.isBitSet( 4 )).isFalse();
        assertThat(bitmask.isBitSet( 5 )).isFalse();
        assertThat(bitmask.isBitSet( 6 )).isFalse();
    }


    @Test
    public void shouldReturnConsecutiveValues()
    {
        new NonStrictExpectations() {{
            bitmask.getBitMaskValue();
            returns (Long.valueOf( 1), Long.valueOf(2), Long.valueOf( 7 ));
            result = Long.valueOf( 0L );
        }};

        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 1L );
        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 2L );
        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 7L );

        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 0L );
        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 0L );
        assertThat( bitmask.getBitMaskValue() ).isEqualTo( 0L );
    }
}
