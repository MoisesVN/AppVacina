import { View,Text,TouchableOpacity,Image } from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "./style";

export default function Info(){
    const navigation = useNavigation();
   
    return(
    <View style={styles.Tela1}>
        <View style={styles.Tela}> 
        <TouchableOpacity onPress={() => navigation.navigate("Home")} style={styles.botao}>
        <Image source={require("../imagens/kisspng-brand-logo-black-and-white-triangle-arrow-symbol-5a76c6d1df2c13.8388288415177335859141 (1).png")}/>
    </TouchableOpacity>
    <View style={styles.Tela}><Text style={styles.Text}>informações do cadastro</Text>
    
    <View style={styles.TelaUser}>  
        <Text style={styles.TextUser}>CPF:123.456.789.10</Text>
        <Text style={styles.TextUser}>EMAIL:meuemail@.com </Text>
        <Text style={styles.TextUser}>SENHA:12345678</Text>

    </View>
    
    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.botao2}>
    <Image source={require("../imagens/kisspng-computer-icons-emergency-exit-download-clip-art-exit-door-5b2c9a0a3c76a8.0319592615296496742477 (1).png")}/>
    </TouchableOpacity>
    
    </View>
    </View>
    </View>
    
    )
}
