import React, { useState} from "react";
import { View, Text, TouchableOpacity} from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function CarteiraHome(){
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return(
        <View>
            <View>
                <Text style={styles.textTitle}>Deve ser importado os componetes dessa pagina para ser exibida na pagina do home</Text>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Home")}
                    >
                        <Text style={styles.textButtonAcessar}>Volta pagina Home</Text>
                    </TouchableOpacity>              

            </View>
        </View>
        
    )


}