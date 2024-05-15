import { View,Text,StyleSheet,TouchableOpacity,Image } from "react-native";
import { useNavigation } from "@react-navigation/native";

export default function Info(){
    const navigation = useNavigation();
    return(
    <View style={styles.Tela1}>
        <View style={styles.Tela}> 
        <TouchableOpacity onPress={() => navigation.navigate("Home")} style={styles.botao}>
        <Image source={require("../imagens/kisspng-brand-logo-black-and-white-triangle-arrow-symbol-5a76c6d1df2c13.8388288415177335859141 (1).png")}/>
    </TouchableOpacity>
    <Text style={styles.Text}>Carteira Aberta</Text>
    </View>
    </View>
    )
}
const styles = StyleSheet.create({
    botao:{
        marginLeft:20,
        marginTop:40,
        padding:10,
        backgroundColor:'#392DE9',
        borderRadius:8,
    },
    Tela:{
        alignItems:'flex-start',
    },
    Tela1:{
        flex:1,
        backgroundColor:'#1E90FF'
    },
    Text:{marginTop:30,
        marginLeft:20,
        fontSize: 20,
    },
    Text2:{
        color:'#FFFFFF',
        fontSize:20
    }
})