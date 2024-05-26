import { View,Text,TouchableOpacity,Image } from "react-native";
import { useNavigation } from "@react-navigation/native";
import  styles  from "./style.js";

export default function Info(){
    const navigation = useNavigation();
    return(
    <View style={styles.Tela1}>
        <View style={styles.Tela}> 
        <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.botao}>
        <Image source={require("../imagens/kisspng-brand-logo-black-and-white-triangle-arrow-symbol-5a76c6d1df2c13.8388288415177335859141 (1).png")}/>
    </TouchableOpacity>
    <View style={styles.Tela}><Text style={styles.Text}>Tela de cadastro</Text>
    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.botao2}>
    <Text style={styles.Text2}>Confirmar</Text>
    </TouchableOpacity>
    </View>
    </View>
    </View>
    )
}
