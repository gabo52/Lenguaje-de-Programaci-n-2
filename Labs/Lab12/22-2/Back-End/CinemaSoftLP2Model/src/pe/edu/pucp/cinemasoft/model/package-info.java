@XmlJavaTypeAdapters({
    @XmlJavaTypeAdapter(value=TimeAdapter.class)
})
package pe.edu.pucp.cinemasoft.model;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;